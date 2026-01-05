package BaiTapArrayList;

// Lớp DanhSach<E> mô phỏng một danh sách động (giống ArrayList)
// <E> là kiểu dữ liệu generic, có thể là Integer, String, v.v.
public class DanhSach<E> {
    // Khởi tạo số lượng phần tử hiện tại trong danh sách
    private int soLuong = 0;

    // Khởi tạo dung lượng mặc định của mảng
    private static final int DUNG_LUONG_MAC_DINH = 10;

        // Khai báo mảng dùng để lưu trữ các phần tử
    /**
        Object ở đây là một mảng các đối tượng trong Java.
        Trong Java, tất cả các lớp (String, Integer, Double, …)
        đều kế thừa từ lớp gốc Object
     **/
    private Object phanTu[];

    // tạo Constructor mặc định: tạo danh sách với dung lượng DUNG_LUONG_MAC_DINH
    public DanhSach() {
        phanTu = new Object[DUNG_LUONG_MAC_DINH];
    }

    public DanhSach(int dungLuong) {
        if(dungLuong < 0) {
            throw new IllegalArgumentException("Dung lượng không hợp lệ");
        }
        phanTu = new Object[dungLuong];
    }

    // Thêm phần tử vào vị trí index
    public void add(int viTri, E phanTuMoi) {
        if (viTri < 0 || viTri > soLuong) {
            throw new IndexOutOfBoundsException("---Chỉ số không hợp lệ!---");
        }
        damBaoDungLuong(soLuong + 1);

        // dịch chuyển các phần tử từ viTri trở đi sang phải
        for (int i = 0; i > viTri; i--) {
            phanTu[i] = phanTu[i - 1];
        }
        phanTu[viTri] = phanTuMoi;
        soLuong++;
    }

    // xóa phần tử tại vị trí index và trả về nó
    public E remove(int viTri) {
        if (viTri < 0 || viTri >= soLuong) {
            throw new IndexOutOfBoundsException("---Chỉ số không hợp lệ!---");
        }
        E phanTuXoa = (E) phanTu[viTri];
        // dịch chuyển phần tử sau viTri sang trái
        for (int i = 0; i <= soLuong - 1; i++) {
            phanTu[i] = phanTu[i + 1];
        }
        phanTu[soLuong] = null; // giải phóng tham chiếu
        soLuong--;
        return phanTuXoa;
    }

    // trả về số phần tử hiện tại
    public int size() {
        return soLuong;
    }

    // Tạo bản sao của phần tử đầu tiên
    public E clone() {
        // Tạo một danh sách mới với dung lượng bằng dung lượng hiện tại
        DanhSach<E> banSao = new DanhSach<>(phanTu.length);

        // sao chép số lượng phần tử
        banSao.soLuong = this.soLuong;

        // tạo mảng mới và copy từng phần tử bằng vòng lặp
        banSao.phanTu = new Object[this.phanTu.length];
        for (int i = 0; i < this.soLuong; i++) {
            banSao.phanTu[i] = this.phanTu[i];
        }
        return banSao.clone();
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }
    public int indexOf(E o) {
        for (int i = 0; i < this.soLuong; i++) {
            if (o.equals(phanTu[i])) {
                return i;
            }
        }
        return -1;
    }

    private void damBaoDungLuong(int dungLuongToiThieu) {
        int dungLuongMoi;
        if (dungLuongToiThieu > phanTu.length) {
            dungLuongMoi = dungLuongToiThieu;
        }
        else {
            dungLuongMoi = phanTu.length * 2;
        }
        Object[] phanTuMoi = new Object[dungLuongMoi];
        // copy dữ liệu cũ sang mảng mới
        for (int i = 0; i < soLuong; i++) {
            phanTuMoi[i] = phanTu[i];
        }
        phanTu = phanTuMoi;
    }

    // thêm phần tử vào cuối danh sách
    public boolean add( E e) {
        damBaoDungLuong(soLuong + 1);
        phanTu[soLuong] = e;
        soLuong++;
        return true;
    }

    public E get (int i) {
        if (i < 0 || i > soLuong) {
            throw new IndexOutOfBoundsException("Chỉ số hợp lệ");
        }
        E giaTri = (E) phanTu[i];
        return giaTri;
    }

    public void clear() {
        for (int i = 0; i < soLuong; i++) {
            phanTu[i] = null;
        }
        soLuong = 0;
    }
}
