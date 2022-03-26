package dio.innovationone.CitiesAPI.service;

import dio.innovationone.CitiesAPI.entity.Country;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryService {

    private CountryRepository countryRepository;

    public Page<Country> listAllCountries(Pageable page) {
        return countryRepository.findAll(page);
    }

    public Country findCountryById(Long id) throws NotFoundException {
        verifyIfExists(id);
        Optional<Country> optional = countryRepository.findById(id);

        return optional.get();
    }

    private Country verifyIfExists(Long id) throws NotFoundException {
        return countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }
}
