package me.marciovieira.sb.sample1.beer.controller;

import java.util.List;

import me.marciovieira.sb.sample1.beer.dto.MessageDto;
import me.marciovieira.sb.sample1.beer.dto.MessageDto.MessageType;
import me.marciovieira.sb.sample1.beer.model.Beer;
import me.marciovieira.sb.sample1.beer.repository.BeerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

	@Autowired
	private BeerRepository beerRepository;

	@RequestMapping(value = "/beers", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {

		final List<Beer> listBeers = (List<Beer>) beerRepository.findAll();

		if (listBeers == null || listBeers.isEmpty()) {
			return new ResponseEntity<MessageDto>(new MessageDto(MessageType.WARN, "Beers not found"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Iterable<Beer>>(listBeers, HttpStatus.OK);
	}

	@RequestMapping(value = "/beer", method = RequestMethod.POST)
	public ResponseEntity<?> getSave(@RequestBody final Beer beer) {

		if (beer == null) {
			return new ResponseEntity<MessageDto>(new MessageDto(MessageType.ERROR, "Beer is required"), HttpStatus.BAD_REQUEST);
		}

		final Beer savedBeer = beerRepository.save(beer);

		return new ResponseEntity<Beer>(savedBeer, HttpStatus.OK);

	}

	@RequestMapping(value = "/beer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable("id") final Long id) {

		if (id == null) {
			return new ResponseEntity<MessageDto>(new MessageDto(MessageType.ERROR, "Beer id is required"), HttpStatus.BAD_REQUEST);
		}

		beerRepository.delete(id);

		return new ResponseEntity<MessageDto>(new MessageDto(MessageType.INFO, "Beer deleted"), HttpStatus.OK);
	}

	@RequestMapping(value = "/beer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable("id") final Long id) {

		if (id == null) {
			return new ResponseEntity<MessageDto>(new MessageDto(MessageType.ERROR, "Beer id is required"), HttpStatus.BAD_REQUEST);
		}

		final Beer beer = beerRepository.findOne(id);

		if (beer == null) {
			return new ResponseEntity<MessageDto>(new MessageDto(MessageType.WARN, "Beer not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Beer>(beer, HttpStatus.OK);

	}
}
