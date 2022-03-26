package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.entity.City;
import dio.innovationone.CitiesAPI.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityResource {

    private CityRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<City> cities(Pageable page) {
        return repository.findAll(page);
    }


}