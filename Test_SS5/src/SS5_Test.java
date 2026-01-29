import java.util.Scanner;
import java.util.regex.Pattern;

public class SS5_Test {
    public static void addMSSV(String[] MSSV){

    }
    public static void main(String[] args) {
        String[] MSSV= new String[100];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("""
                    Menu:
                    1. Hiển thị: In ra danh sách MSSV hiện có
                    2. Thêm mới (Có Regex): * Yêu cầu nhập MSSV mới
                    3. Cập nhật
                    4. Xóa
                    5. Tìm kiếm
                    6. Thoat
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    if (count == 0) {
                        System.out.println("Danh sách MSSV đang rỗng");
                        break;
                    }
                    System.out.println("Danh sách MSSV:");
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + MSSV[i]);
                    }
                    break;
                case 2:
                    if (count >= MSSV.length) {
                        System.out.println("Danh sách đã đầy");
                        break;
                    }

                    String newMSSV;
                    while (true) {
                        System.out.print("Nhập MSSV mới: ");
                        newMSSV = sc.nextLine().trim().toUpperCase();

                        if (!Pattern.matches("^B\\d{7}$", newMSSV)) {
                            System.out.println("Sai định dạng (B + 7 số)");
                            continue;
                        }

                        boolean check = false;
                        for (int i = 0; i < count; i++) {
                            if (newMSSV.equals(MSSV[i])) {
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("MSSV đã tồn tại");
                            continue;
                        }

                        MSSV[count++] = newMSSV;
                        System.out.println("Thêm thành công!");
                        break;
                    }
                    break;
                case 3:
                    if (count == 0) {
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    while (true){
                        System.out.println("Nhập vị ví index cần sửa");
                        int index = Integer.parseInt(sc.nextLine());
                        System.out.println("MSSV mới: ");
                        String addNewMSSV = sc.nextLine();
                        if (index > count){
                            System.out.println("Vị trí không hợp lệ");
                        }else {
                            MSSV[index] = addNewMSSV;
                            break;
                        }
                    }
                    break;
                case 4:
                    if (count == 0) {
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    System.out.print("Nhập MSSV cần xóa: ");
                    String delMSSV = sc.nextLine().trim().toUpperCase();
                    int indexDel = 0;
                    for (int i = 0; i < count; i++) {
                        if (delMSSV.equals(MSSV[i])) {
                            indexDel = i;
                            break;
                        }
                    }

                    if (indexDel == 0) {
                        System.out.println("Không tìm thấy MSSV");
                        break;
                    }

                    for (int i = indexDel; i < count - 1; i++) {
                        MSSV[i] = MSSV[i + 1];
                    }
                    MSSV[--count] = null;
                    System.out.println("Xóa thành công");
                    break;
                case 5:
                    if (count == 0) {
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    System.out.print("Nhập MSSV cần tìm: ");
                    String findMSSV = sc.nextLine().trim().toUpperCase();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (findMSSV.equals(MSSV[i])) {
                            System.out.println("Tìm thấy tại vị trí: " + (i + 1));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy MSSV");
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("không thuộc menu");


            }
        }while (choice != 6);


    }
}
