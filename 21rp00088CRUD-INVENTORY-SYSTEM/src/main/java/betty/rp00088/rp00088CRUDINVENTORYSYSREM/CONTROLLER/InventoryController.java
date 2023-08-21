package betty.rp00088.rp00088CRUDINVENTORYSYSREM.CONTROLLER;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import betty.rp00088.rp00088CRUDINVENTORYSYSREM.MODEL.Inventory;
import betty.rp00088.rp00088CRUDINVENTORYSYSREM.REPOSITORY.InventoryRepository;


@Controller


public class InventoryController {

    @Autowired
    private InventoryRepository irepo;
    @GetMapping({"/"})
    public ModelAndView showDashboard() {
        ModelAndView dashView = new ModelAndView("index");
        return dashView;
    }

    
	  @GetMapping({"/listInventory"}) 
	  public ModelAndView listInventory() {
	  ModelAndView ls = new ModelAndView("List"); 
	  List<Inventory> inventoryList =irepo.findAll(); 
	  ls.addObject("inventoryList", inventoryList);
	  return ls; 
	  }
	 
		
      @GetMapping("/addForm") 
	  public ModelAndView addForm() { 
	  ModelAndView ad = new ModelAndView("add"); 
	  Inventory newItem = new Inventory();
	  ad.addObject("add", newItem);
	  return ad; 
	  }
		  
	  @GetMapping("/save") 
	  public String addItem(@ModelAttribute Inventory inv) { 
		 
	  irepo.save(inv);  
	  return "redirect:/listInventory"; 
	  }
		  
	  @GetMapping("/editForm") 
	  public ModelAndView editForm(@RequestParam long inventoryId){ 
	  ModelAndView edi = new ModelAndView("add");
	  Inventory inventoryItem = irepo.findById(inventoryId).get();
	  edi.addObject("add",inventoryItem); 
	  return edi; 
	  }
		  
		 
	 
		 
	  @GetMapping("/delete") 
	  public String delete(@RequestParam long inventoryId) { 
	  
	  irepo.deleteById(inventoryId);
	 
	  return "redirect:/listInventory"; 
	 }
		
}


