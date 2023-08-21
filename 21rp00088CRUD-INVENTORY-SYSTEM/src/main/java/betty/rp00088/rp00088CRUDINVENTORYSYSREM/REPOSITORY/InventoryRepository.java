package betty.rp00088.rp00088CRUDINVENTORYSYSREM.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import betty.rp00088.rp00088CRUDINVENTORYSYSREM.MODEL.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}

