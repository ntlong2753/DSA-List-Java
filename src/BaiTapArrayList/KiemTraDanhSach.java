package BaiTapArrayList;

public class KiemTraDanhSach {
    public static void main(String[] args) {
        DanhSach<String> ds = new DanhSach<>();

        // Thêm phần tử
        ds.add("A");
        ds.add("B");
        ds.add("C");

        // Kiểm tra size
        System.out.println("Kích thước: " + ds.size()); // 3

        // Kiểm tra contains
        System.out.println("Có chứa B không? " + ds.contains("B")); // true
        System.out.println("Có chứa Z không? " + ds.contains("Z")); // false

        // Lấy phần tử tại vị trí
        System.out.println("Phần tử tại vị trí 1: " + ds.get(1)); // B

        // Tìm vị trí phần tử
        System.out.println("Vị trí của C: " + ds.indexOf("C")); // 2

        // Xóa phần tử
        String biXoa = ds.remove(0);
        System.out.println("Đã xóa: " + biXoa); // A
        System.out.println("Kích thước sau khi xóa: " + ds.size()); // 2

        // Clear danh sách
        ds.clear();
        System.out.println("Kích thước sau khi clear: " + ds.size()); // 0
    }
}

