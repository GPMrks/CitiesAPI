package dio.innovationone.CitiesAPI.repository;

import dio.innovationone.CitiesAPI.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
