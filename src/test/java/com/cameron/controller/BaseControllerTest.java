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
import com.cameron.service.ActorService;
import com.cameron.service.MovieService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class BaseControllerTest {

	@Mock
	private IActorService actorService;

	@Mock
	private IMovieService movieService;

	BaseController controller = new BaseController(actorService, movieService);

	@BeforeEach
	void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testActorEndpoint() {
		Mockito.when(actorService.getActors()).thenReturn(new ArrayList<Actor>());
		List<Actor> rs = controller.getActors();
		Assert.assertNotNull(rs);
	}





}
