package me.marciovieira.sb.sample1.beer.repository;

import me.marciovieira.sb.sample1.beer.model.Beer;

import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Long> {

}
