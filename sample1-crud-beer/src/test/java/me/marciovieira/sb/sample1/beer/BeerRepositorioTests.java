package me.marciovieira.sb.sample1.beer;

import me.marciovieira.sb.sample1.beer.model.Beer;
import me.marciovieira.sb.sample1.beer.repository.BeerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BeerCatalogApplication.class)
@WebAppConfiguration
public class BeerRepositorioTests {

	@Autowired
	private BeerRepository beerRepository;

	@Test
	public void save() {
		final Beer beer = new Beer();

		beer.setName("STELLA ARTOIS");
		beer.setDescription("A receita de Stella Artois foi criada, originalmente, como um presente de Natal para os habitantes da pequena cidade de Leuven, na Bélgica. ");

		beerRepository.save(beer);
	}

	@Test
	public void findById() {
		final Beer beer = beerRepository.findOne(1L);

		System.out.println(beer);
	}

	@Test
	public void findAll() {
		final Iterable<Beer> beers = beerRepository.findAll();

		for (final Beer beer : beers) {
			System.out.println(beer);
		}
	}

}
