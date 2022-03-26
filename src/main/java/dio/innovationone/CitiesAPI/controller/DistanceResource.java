package dio.innovationone.CitiesAPI.controller;

import dio.innovationone.CitiesAPI.service.DistanceService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DistanceResource {

    final static Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return service.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return service.distanceByCubeInMeters(city1, city2);
    }

}
