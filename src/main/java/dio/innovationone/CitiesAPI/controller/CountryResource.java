package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.entity.Country;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryResource {

    private CountryService countryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Country> listAllCountries(final Pageable page) {
        return countryService.listAllCountries(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Country getOneCountry(@PathVariable Long id) throws NotFoundException {
        return countryService.findCountryById(id);
    }
}
