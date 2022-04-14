package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.entity.City;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v5/cities")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityResource {

    private CityService cityService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<City> listAllCities(final Pageable page) {
        return cityService.listAllCities(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City findCityById(@PathVariable Long id) throws NotFoundException {
        return cityService.findCityById(id);
    }
}
