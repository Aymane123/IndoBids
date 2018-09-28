package web.offer;

import domain.catalogus.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.InputService;

/**
 * API Controller to handle requests for a {@Catalog}
 */
@RestController
public class OffersCotroller {
    private final InputService catalogService;

    @Autowired
    public OffersCotroller(InputService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(value = "/getCatalog/{catalogId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Catalog> getCatalog(@PathVariable int catalogId) {
        Catalog catalog = catalogService.getCatalogById(catalogId);
        if (catalog != null) {
            return ResponseEntity.ok(catalog);
        } else {
            return ResponseEntity.ok(catalog);
        }
    }
}
