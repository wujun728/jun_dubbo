import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.tika.exception.TikaException;

/**
 * TODO
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2019-06-28 08:58
 */
public class JFrameDemo extends JFrame {

  private static File openFile;                        //文件类
  private static StringBuilder sql;
  static JTextArea jTextArea;
  static JScrollPane jsp;
  static JPanel jp = new JPanel();

  public static void main(String[] agrs) {

    JFrame frame = new JFrame("建表不再烦恼~~");    //创建一个JFrame对象

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 默认关闭方式
    frame.setBounds(300, 100, 400, 200);    //设置窗口大小和位置
    //创建一个JPanel对象
    JButton closeBtn = new JButton("关闭程序");
    JButton downBtn = new JButton("下载模板");
    JButton btnBrowse = new JButton("选择excel文件");

    jp.add(btnBrowse);
    jp.add(downBtn);
    jp.add(closeBtn);

    jTextArea = new JTextArea();
    jTextArea.setLineWrap(true);
    jp.add(jTextArea);


    jp.setBackground(Color.white);    //设置背景色
    frame.add(jp);    //将面板添加到窗口
    jp.add(jTextArea, BorderLayout.SOUTH);

    closeBtn.addActionListener(e -> System.exit(0));
    btnBrowse.addActionListener(e -> {

      //自己撰写
      JFileChooser chooser = new JFileChooser(); //文件选择
      chooser.showOpenDialog(chooser);        //打开文件选择窗
      openFile = chooser.getSelectedFile();    //获取选择的文件

      try {
        sql = Test.getSql(openFile);
        if (sql != null) {
          System.out.println(sql.toString());
          JOptionPane.showConfirmDialog(jp, sql.toString(), "建表语句已创建~~", JOptionPane.WARNING_MESSAGE);
//          jTextArea.setText(sql.toString());
//          jsp = new JScrollPane(jTextArea);
//          Dimension size = jTextArea.getPreferredSize();
//          jsp.setBounds(1000 , 1000, 1000, 1000);
//          jp.add(jsp);
        }
      } catch (IOException e1) {
        System.out.println("e1");
      } catch (TikaException e1) {
        System.out.println("e2");
      }
    });

    frame.setVisible(true);    //设置窗口可见
  }

}
