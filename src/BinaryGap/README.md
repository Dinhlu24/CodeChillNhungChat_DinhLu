# Giải thuật tìm Khoảng Nhị Phân (Binary Gap)

Bài viết này giải thích phương pháp tìm "khoảng nhị phân" (dãy số 0 liên tiếp được bao quanh bởi các số 1) dài nhất của một số nguyên dương.

## Ý tưởng thuật toán

Thuật toán được chia làm 2 giai đoạn chính:

### 1. Chuyển đổi số nguyên sang chuỗi nhị phân
Sử dụng hàm `integerToBinary(int n)` để chuyển đổi số nguyên `n` thành một chuỗi nhị phân (`String`).
- Dùng vòng lặp `while` chia liên tục số `n` cho 2, lấy phần dư `n % 2` ghép vào `StringBuilder`.
- Cuối cùng đảo ngược chuỗi (`reverse()`) để thu được chuỗi nhị phân chính xác.

### 2. Tìm và đếm khoảng nhị phân dài nhất
Hàm `solution(int n)` đảm nhận việc duyệt chuỗi và đếm số lượng ký tự `0` hợp lệ:
- Khởi tạo biến `maxCount = 0` để lưu kỷ lục độ dài lớn nhất.
- Duyệt qua từng ký tự của chuỗi nhị phân bằng vòng lặp `for` với biến chạy `i`.
- **Tối ưu hóa duyệt:** Nếu ký tự đang xét là `1`, sử dụng lệnh `continue` để bỏ qua ngay, giúp tối ưu việc không phải kiểm tra các điều kiện `while` ở bên dưới nhiều lần.
- **Đếm số 0:** Nếu ký tự hiện tại là `0`, kích hoạt vòng lặp `while` để đếm. Trong vòng `while` này:
    - Tăng biến `count` lên 1.
    - Tăng chỉ số `i` lên 1 tương ứng để tiến tới ký tự tiếp theo.
    - Vòng lặp dừng lại khi gặp lại ký tự `1` hoặc khi đã duyệt đến cuối chuỗi.
- **Kiểm tra tính hợp lệ (Mấu chốt):** Sau khi kết thúc vòng `while`, tiến hành kiểm tra 2 điều kiện để cập nhật `maxCount`:
    1. `maxCount < count`: Khoảng trống vừa tìm được có dài hơn kỷ lục cũ không?
    2. `i != binaryString.length()`: Vị trí `i` lúc này có trỏ vào một ký tự `1` hay không? Nếu `i` bằng với chiều dài chuỗi (tức là đã chạy vượt rào), có nghĩa là dãy số `0` vừa đếm không được chốt đuôi bằng số `1`. Điều này là không hợp lệ vì một khoảng nhị phân bắt buộc phải bắt đầu bằng `1` và kết thúc bằng `1`.
- Trả về kết quả `maxCount` cuối cùng.