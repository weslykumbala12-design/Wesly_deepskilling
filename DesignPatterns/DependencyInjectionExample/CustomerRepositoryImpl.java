public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        if (id == 101) {
            return "John Wesly";
        } else if (id == 102) {
            return "David";
        } else {
            return "Customer Not Found";
        }

    }

}