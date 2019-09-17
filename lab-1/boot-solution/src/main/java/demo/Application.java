package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Player;
import demo.domain.Team;
import demo.repository.TeamRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	@Autowired TeamRepository teamRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /**
     * preparing database for spring data JPA repository
     */
    @PostConstruct
	public void init() {

		List<Team> teams = new ArrayList<>();
		
	  	Team team = new Team();
	  	team.setId(600032L);
	  	team.setLocation("Chennai");
	  	team.setName("Chennai SK");
	  	// add players
	  	Set<Player> chennai_players = new HashSet<>();
	  	chennai_players.add(new Player("Virat","one"));
	  	chennai_players.add(new Player("De Villers","Two"));
		team.setPlayers(chennai_players);
	  	teams.add(team);
	  	
	  	team = new Team();
	  	team.setId(560054L);
	  	team.setLocation("Bangalore");
	  	team.setName("Bangalore RC");
	  	// add players
	  	Set<Player> bangalore_players = new HashSet<>();
	  	bangalore_players.add(new Player("MS Dhoni","one"));
	  	bangalore_players.add(new Player("Suresh raina","Two"));
	  	team.setPlayers(bangalore_players);
	  	teams.add(team);
	  	teamRepository.saveAll(teams);
	}    
    
}
