import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Author : Quy Vu
*/
public class Customer implements Action {
    private static Scanner in =new Scanner(System.in);
    private List<Item> pickList;
    private Menu presentMenu;
    private int total = 0;

    private class Item {
        private int quantity;
        private Dish dish;


        public Item(Dish dish) {
            this.dish = dish;
        }

        public Item(int quantity, Dish dish) {
            this.quantity = quantity;
            this.dish = dish;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public Dish getDish() {
            return dish;
        }

        public int getCalculateItem(){
            return dish.getDishPrice()*quantity;
        }

    }

    public Customer(Menu menu) {
        this.presentMenu = menu;
        this.pickList = new ArrayList<>();
    }

    public void getPresentMenu() {
        presentMenu.getListMenu();
    }

    public int getTotal(){
        for (Item item: pickList) {
            total+=item.getCalculateItem();
        }
        return total;
    }

    public void getPickList() {
        System.out.println("Thành tiền");
        for (Item item: pickList) {
            System.out.println(item.getDish().getDishName()+"("+item.quantity+"*"+item.dish.getDishPrice()+"$): " +item.getCalculateItem()+"$");
        }
        System.out.println("\nThành tiền: " + getTotal() +"$");
    }




    @Override
    public void addDish() {
        System.out.println("Thêm món");
        presentMenu.getListMenu();
        System.out.println("Nhập ID món");
        try {
            int idNew = in.nextInt();
            if (presentMenu.getMenu().stream().anyMatch(dish -> dish.getDishID() == idNew)) {
                Dish dishNew = presentMenu.getMenu().get(idNew);
                System.out.println("Mời bạn nhập số lượng "+ dishNew.getDishName());
                int qty = in.nextInt();
                Item item = new Item(qty, dishNew);
                pickList.add(item);
                System.out.println("Thêm món thành công");
            }else {
                System.out.println("ID món không tồn tại");
            }
        } catch (Exception e) {
            System.out.println("Số lượng và ID phải ở dạng số");
        }


    }

    @Override
    public void removeDish() {
        System.out.println("Xóa món");
        System.out.println("Nhập ID món cần xóa");
        try {
            int id = in.nextInt();
            pickList.removeIf(item -> item.dish.getDishID() == id);
            System.out.println("Hoàn tất việc xóa");
        }catch (Exception e){
            System.out.println("ID phải ở dạng số");
        }
    }

    @Override
    public void updateDish() {
        System.out.println("Sửa số lượng");
        System.out.println("Mời bạn nhập ID món cần sửa");
        try {
            int id =in.nextInt();
            if(pickList.stream().anyMatch(item -> item.dish.getDishID()==id)){
                System.out.println("Mời bạn nhập số lượng thay đổi");
                int qty = in.nextInt();
               pickList.stream().filter(item -> item.dish.getDishID()==id)
                       .findAny().get()
                       .setQuantity(qty);
            }else {
                System.out.println("ID không tồn tại");
            }

            System.out.println("Hoàn tất việc sửa");
        }catch (Exception e){
            System.out.println("ID phải ở dạng số");
        }
    }






}
