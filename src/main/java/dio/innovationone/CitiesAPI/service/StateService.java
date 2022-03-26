package dio.innovationone.CitiesAPI.service;

import dio.innovationone.CitiesAPI.entity.State;
import dio.innovationone.CitiesAPI.exception.NotFoundException;
import dio.innovationone.CitiesAPI.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateService {

    private StateRepository stateRepository;

    public List<State> listAllStates() {
        return stateRepository.findAll();
    }

    public State getOneState(Long id) throws NotFoundException {
        verifyIfExists(id);
        Optional<State> optional = stateRepository.findById(id);
        return optional.get();
    }

    private State verifyIfExists(Long id) throws NotFoundException {
        return stateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }
}
