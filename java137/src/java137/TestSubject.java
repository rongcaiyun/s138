package java137;

import java.util.List;
import java.util.Scanner;

import com.dao.SubjectDao;
import com.entity.Subject;

public class TestSubject {

	public static void main(String[] args) {
		SubjectDao sd = new SubjectDao();
		do {
			System.out.println("科目管理系统：1.查询  2.增加  3.删除 4.更新   6.退出");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			switch (option) {
			case 1:// 查询
				List<Subject> list = sd.getAll();
				for (Subject subject : list) {
					System.out.println(subject);
				}
				break;
			case 2:// 增加
				Subject s = new Subject();
				s.setSubjectName("spring");
				s.setClassHour(100);
				s.setGradeId(3);
				int count = sd.add(s);
				if (count > 0) {
					System.out.println("增加成功!");
				} else {
					System.out.println("增加失败！");
				}
				break;
			case 3:// 删除
				System.out.println("请输入要删除的科目编号：");
				int count1 = sd.del(input.nextInt());
				if (count1 > 0) {
					System.out.println("删除成功!");
				} else {
					System.out.println("删除失败！");
				}
				break;
			case 4:// 更新
				System.out.println("请输入科目编号：");
				int sno = input.nextInt();
				System.out.println("请输入科目名称：");
				String sname = input.next();
				System.out.println("请输入课时数：");
				int hour = input.nextInt();
				System.out.println("请输入年级编号：");
				int gid = input.nextInt();
				Subject st = new Subject(sno, sname, hour, gid);

				int count2 = sd.update(st);
				if (count2 > 0) {
					System.out.println("更新成功!");
				} else {
					System.out.println("更新失败！");
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("输入错误！");
				break;
			}
		} while (true);

	}

}
