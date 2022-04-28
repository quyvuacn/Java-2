import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Author : Quy Vu
*/
public class Menu implements Action{
    private List<Dish> menu;
    private static int sizeMenu = 5;
    private static Scanner in = new Scanner(System.in);

    public Menu() {
        this.menu = new ArrayList<>();
        Dish dish1 = new Dish(0,"Nước lọc",20,0);
        Dish dish2 = new Dish(1,"Hướng Dương",30,1);
        Dish dish3 = new Dish(2,"Cafe truyền thống",40,2);
        Dish dish4 = new Dish(3,"Espresso",40,0);
        Dish dish5 = new Dish(4,"Cappuccino",45,1);
        Dish dish6= new Dish(5,"Cafe Latte",45,2);
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        menu.add(dish4);
        menu.add(dish5);
        menu.add(dish6);
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void getListMenu(){
        System.out.println("++++Menu++++");
        for (Dish dish: menu) {
            System.out.println(dish.getDishID()+"."+dish.getDishName() +": " +"size("+dish.getDishSize()+") "+ dish.getDishPrice()+"$");
        }
    }

    @Override
    public void addDish(){
        System.out.println("Thêm món");
        try {
                System.out.println("Mời bạn nhập tên món");
                String nameNew = in.next();
                System.out.println("Mời bạn nhập giá");
                int priceNew = in.nextInt();
                System.out.println("Mời bạn nhập size");
                int sizeNew = in.nextInt();
                Dish dishNew = new Dish(sizeMenu+1,nameNew,priceNew,sizeNew);
                sizeMenu++;
                menu.add(sizeMenu,dishNew);
                System.out.println("Thêm thành công");

        } catch (Exception e) {
            System.out.println("Giá không chứa kí tự chữ");
        }
    }

    public void addDish(Dish dish){
        dish.setDishID(sizeMenu);
        if(menu.stream().allMatch(dishItem -> !(dishItem.getDishID()==dish.getDishID()))){
            menu.add(sizeMenu,dish);
            System.out.println("Thêm thành công");
            sizeMenu++;
        }else {
            System.out.println("Không thể thêm món có ID đã tồn tại");
        }
    }

    public void removeDish(){
        System.out.println("Mời bạn nhập ID món cần xóa");
        int ID = in.nextInt();
        try {
            if(menu.stream().allMatch(dishItem -> dishItem.getDishID()==ID )){
                menu.remove(menu.get(ID));
                sizeMenu--;
            }else {
                System.out.println("ID không tồn tại trong menu");
            }
        } catch (Exception e) {
            System.out.println("ID nhập không chứa kí tự chữ");
        }

    }

    @Override
    public void updateDish(){
        System.out.println("Mời bạn nhập ID món cần chỉnh sửa");
        int ID = in.nextInt();
        if(menu.stream().allMatch(dishItem -> dishItem.getDishID()==ID )){
            System.out.println("Mời bạn nhập lựa chọn chỉnh sửa");
            System.out.println("1.Sửa tên");
            System.out.println("2.Sửa giá");
            int s = in.nextInt();
            if(s==1){
                String nameNew = in.next();
                menu.get(ID).setDishName(nameNew);
            }else if(s==2){
                int priceNew = in.nextInt();
                try {
                    menu.get(ID).setDishPrice(priceNew);
                } catch (Exception e) {
                    System.out.println("Giá không thế là String");
                }
            }else {
                System.out.println("Lựa chọn không đúng");
            }
        }else {
            System.out.println("ID không tồn tại trong menu");
        }

    }




}
