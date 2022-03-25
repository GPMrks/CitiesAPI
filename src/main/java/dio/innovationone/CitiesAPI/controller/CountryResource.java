package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.entity.Country;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.repository.CountryRepository;
import dio.innovationone.CitiesAPI.response.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryResource {

    private CountryRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Country getOne(@PathVariable Long id) throws NotFoundException {
        verifyIfExists(id);
        Optional<Country> optional = repository.findById(id);

        return optional.get();
    }

    private Country verifyIfExists(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    private MessageResponse createMessageResponse(String message, Long id) {
        return MessageResponse
                .builder()
                .message(message + id)
                .build();
    }

}
