import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

/**
 * TODO
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2019-06-27 17:09
 */
public class Test {

  private static final String SPACE = "  ";
  private static final String NOT_NULL = "not null";
  private static final String NN = "\n";
  private static final String ADD_COMMENT = "comment on column ";

  public static StringBuilder getSql(File file)
      throws IOException, TikaException, TikaException {

    List<DBbean> list = new ArrayList<>();
    Tika tika = new Tika();
    // 读取文件.
    String s = tika.parseToString(file);
    // 切割 行.
    String[] split = s.split("\n");
    for (int i = 2; i < split.length; i++) {
      DBbean dBbean = new DBbean();
      String[] in = split[i].split("\t");
      for (int j = 1; j < in.length; j++) {
        switch (j) {
          case 1:
            dBbean.setNumber(in[1]);
            break;
          case 2:
            dBbean.setEnglishName(in[2]);
            break;
          case 3:
            dBbean.setChineseName(in[3]);
            break;
          case 4:
            dBbean.setNameType(in[4]);
            break;
          case 5:
            dBbean.setKey(!in[5].equals(""));
            break;
          case 6:
            dBbean.setNull(!in[6].equals(""));
            break;
          case 7:
            dBbean.setComment(in[7]);
            break;
        }

      }
      list.add(dBbean);
    }

    String tableName = "ABC";
    // 建表
    StringBuilder sql = crateTable(list, tableName);
    // 注释
    sql.append("\n").append(addComment(list, tableName));
    // 主键
    sql.append("\n").append(addKey(list, tableName));
    return sql;
  }

  /**
   * 加主键
   */
  private static StringBuilder addKey(List<DBbean> list, String tableName) {
    StringBuilder addKey = new StringBuilder("alter table " + tableName +" add constraint " + tableName + "_PK primary key (");
    list.stream().filter(o -> o.isKey())
        .forEach(o -> addKey.append(o.getEnglishName()).append(","));
    return new StringBuilder(addKey.subSequence(0, addKey.length() - 1)).append(");");
  }

  /**
   * 注释
   *
   * @param list 数据
   * @param tableName 表名
   */
  private static StringBuilder addComment(List<DBbean> list, String tableName) {
    StringBuilder sql = new StringBuilder();
    for (DBbean obj : list) {
      sql.append(ADD_COMMENT).append(tableName).append(".").append(obj.getEnglishName())
          .append(" is ").append("\'").append(obj.getChineseName());
      if (obj.getComment() != null && !obj.getComment().equals("")) {
        sql.append(",").append(obj.getComment());
      }
      sql.append("\';\n");
    }
    return sql;
  }


  /**
   * 数据库建表语句.
   *
   * @param list 数据
   * @param tableName 数据库名称
   * @return 建表语句
   */
  private static StringBuilder crateTable(List<DBbean> list, String tableName) {

    StringBuilder sql = new StringBuilder();
    sql.append("create table ").append(tableName).append("(").append(NN);
    for (DBbean obj : list) {
      sql.append(obj.getEnglishName()).append(SPACE).append(obj.getNameType()).append(SPACE);
      if (obj.isKey()) {
        sql.append(NOT_NULL).append(SPACE);
      }
      sql.append(",").append(NN);
    }
    sql = new StringBuilder(sql.substring(0, sql.length() - 2)).append(NN);
    return sql.append(");");
  }


  private static StringBuilder trim(StringBuilder sql) {
    int len = sql.length();
    int st = 0;
    char[] val = sql.toString().toCharArray();    /* avoid getfield opcode */

    while ((st < len) && (val[st] <= ' ')) {
      st++;
    }
    while ((st < len) && (val[len - 1] <= ' ')) {
      len--;
    }
    return new StringBuilder(sql.substring(st, len));
  }
}
