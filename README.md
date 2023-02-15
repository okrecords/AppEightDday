# AppEightDday
## ImageView 흑백
- ColorMatrix 메서드를 이용
- setSaturation (float sat) : A value of 0 maps the color to gray-scale. 1 is identity.

AppEightDday에서 [ImageView 흑백](https://github.com/okrecords/AppEightDday/blob/779c8f96d90093bb45fb9c4e17b3c688c79310ad/app/src/main/java/com/okre/appeightdday/MainActivity.kt#L20)
<br/><br/><br/>

## DatePickerDialog
- 날짜 선택 도구 + Dialog
1. 현재시간을 담고있는 Calendar 객체를 리턴
```
val calendar_start = Calendar.getInstance()
```
2. DatePickerDialog
```
val today = GregorianCalendar()
val year = today.get(Calendar.YEAR)
val month = today.get(Calendar.MONTH)
val day = today.get(Calendar.DATE)

val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        // set(year: Int, month: Int, date: Int)
        calendar_start.set(p1, p2+1, p3)
    }
}, year, month, day)
dlg.show()
```
AppEightDday에서 [DatePickerDialog](https://github.com/okrecords/AppEightDday/blob/779c8f96d90093bb45fb9c4e17b3c688c79310ad/app/src/main/java/com/okre/appeightdday/MainActivity.kt#L26)
