package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Team;
import demo.repository.TeamRepository;

 //@RestController      //comment @RestController, we are using SpringDataREST with @RestResource to implement the controller
public class TeamController {

	@Autowired TeamRepository teamRepository;
	
	
	// returning data from spring data repository
	@GetMapping("/teams/spring_data")
	public Iterable<Team> getTeamsBySpringData() {
		return teamRepository.findAll();
	}
	
	/**
	 * The findById() returns a Java 8 "Optional", and the get() simply returns the actual Team.
	 * @return
	 */
	@GetMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id){
		return teamRepository.findById(id).get();
	}
	
	/**
	 * prepare data for returning as Restful response
	 * also add ddl-auto property in app.prop to control how JPA(Hibernate) handle schema
	 */
	@GetMapping("/teams/rest")
	public List<Team> getTeamsByRestCall() {
		List<Team> teams = new ArrayList<>();

	  	Team team = new Team();
	  	team.setId(600032L);
	  	team.setLocation("Chennai");
	  	team.setName("Chennai SK");
	  	teams.add(team);
	  	
	  	team = new Team();
	  	team.setId(560054L);
	  	team.setLocation("Bangalore");
	  	team.setName("Bangalore RC");
	  	teams.add(team);
	  	
	  	return teams;
	}
	
}
