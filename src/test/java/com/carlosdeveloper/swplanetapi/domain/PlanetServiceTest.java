package com.carlosdeveloper.swplanetapi.domain;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.carlosdeveloper.swplanetapi.common.PlanetConstants.INVALID_PLANET;
import static com.carlosdeveloper.swplanetapi.common.PlanetConstants.PLANET;

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

  @Test
  public void getPlanet_ByExistingId_ReturnsPlanet(){
    when(planetRepository.findById(1L)).thenReturn(Optional.of(PLANET));
    
    Optional<Planet> sut = planetService.get(1L);

    assertThat(sut).isNotEmpty();
    assertThat(sut.get()).isEqualTo(PLANET);

  } 

  @Test
  public void getPlanet_ByUnexistingId_ReturnsEmpty(){
    when(planetRepository.findById(1L)).thenReturn(Optional.empty());

    Optional<Planet> sut = planetService.get(1L);

    assertThat(sut).isEmpty();
  }

}
