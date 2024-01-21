package ma.emsi.customerfrontthymeleafapp.web;
import ma.emsi.customerfrontthymeleafapp.entities.Customer;
import ma.emsi.customerfrontthymeleafapp.repository.CustomerRepository;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController{
    private CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public String customers(Model model){
        List<Customer> customerList=customerRepository.findAll();
        model.addAttribute("customers",customerList);
        return "customers";
    }
    @GetMapping("/products")
    public String products(Model model){
        return "products";
    }
    @ResponseBody
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
