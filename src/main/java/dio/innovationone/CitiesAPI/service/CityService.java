package dio.innovationone.CitiesAPI.service;

import dio.innovationone.CitiesAPI.entity.City;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityService {

    private CityRepository cityRepository;

    public Page<City> listAllCities(Pageable page) {
        return cityRepository.findAll(page);
    }

    public City findCityById(Long id) throws NotFoundException {
        verifyIfExists(id);
        Optional<City> optional = cityRepository.findById(id);

        return optional.get();
    }

    private City verifyIfExists(Long id) throws NotFoundException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }
}
