package com.sheyu.mybatis.mybatisdemo.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StringToListHandler  extends BaseTypeHandler<List<Integer>> {

    private static final String splitCharset = ",";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        String str = arrayToString(parameter);
        ps.setString(i, str);
    }

    /**
     * @param rs
     * @param columnName Colunm name, when configuration <code>useColumnLabel</code> is <code>false</code>
     */
    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return stringToArray(str);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return stringToArray(str);
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return stringToArray(str);
    }


    /**
     * Integer列表转String
     * 注：使用提前设定好的分隔符分割数组的每一项
     */
    private static String arrayToString(List<Integer> array) {
        StringBuilder res = new StringBuilder();
        if (array != null && array.size() > 0) {
            for (int i=0;i<array.size();i++ ){
                if (i!=(array.size()-1)) {
                    res.append(array.get(i).toString()).append(splitCharset);
                }else{
                    res.append(array.get(i));
                }
            }
        }
        return res.length() > 0 ? res.toString() : null;
    }

    /**
     * 从String转Integer列表
     * 注：String是用分隔符分割的，使用String.split方法可以分解为数组
     */
    private static List<Integer> stringToArray(String str) {
        List<Integer> list = new ArrayList<>();
        if (str != null) {
            String[] array = str.split(splitCharset);
            if (array.length > 0) {
                for (String o : array) {
                    if (o != null && o.length() > 0) {
                        list.add(Integer.parseInt(o));
                    }
                }
            }
        }
        return list;
    }
}
