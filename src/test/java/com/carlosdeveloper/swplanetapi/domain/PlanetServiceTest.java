package com.carlosdeveloper.swplanetapi.domain;

import static com.carlosdeveloper.swplanetapi.common.PlanetConstants.INVALID_PLANET;
import static com.carlosdeveloper.swplanetapi.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {
  @InjectMocks
  private PlanetService planetService;

  @Mock
  private PlanetRepository planetRepository;

  @Test
  public void createPlanet_WithValidData_ReturnsPlanet() {
    when(planetRepository.save(PLANET)).thenReturn(PLANET);

    Planet sut = planetService.create(PLANET);

  }

  @Test
  public void createPlanet_WithInvalidData_throwsException() {
    when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

    assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);

  }

}
