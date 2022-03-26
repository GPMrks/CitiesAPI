package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.entity.State;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.response.MessageResponse;
import dio.innovationone.CitiesAPI.service.StateService;
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

    private final StateService stateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<State> listAllStates() {
        return stateService.listAllStates();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public State getOneState(@PathVariable Long id) throws NotFoundException {
        return stateService.getOneState(id);
    }
}
