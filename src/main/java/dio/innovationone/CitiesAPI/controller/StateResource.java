package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.entity.State;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.repository.StateRepository;
import dio.innovationone.CitiesAPI.response.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateResource {

    private final StateRepository repository;

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public State getOne(@PathVariable Long id) throws NotFoundException {
        verifyIfExists(id);
        Optional<State> optional = repository.findById(id);
        return optional.get();
    }

    private State verifyIfExists(Long id) throws NotFoundException {
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
