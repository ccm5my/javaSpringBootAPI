/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cameron.controller;

import com.cameron.interfaces.IActorService;
import com.cameron.interfaces.IMovieService;
import com.cameron.model.Actor;
import com.cameron.model.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieControllerTest {

	@Mock
	private IMovieService movieService;

	public MovieControllerTest() {
		movieService = mock(IMovieService.class);
	}

	@Test
	public void testMovieEndpoint() {
		//Arrange
		MovieController controller = new MovieController(movieService);
		List<Movie> movieList = new ArrayList();
		Movie movie = new Movie();
		movie.setId(1);
		movie.setTitle("title");
		movieList.add(movie);
		when(movieService.getMovies()).thenReturn(movieList);

		//Act
		List<Movie> rs = controller.getMovies();

		//Assert
		assertNotNull(rs);
		assertTrue(rs.size()==1);
		assertTrue(rs.get(0).equals(movieList.get(0)));
	}


}
