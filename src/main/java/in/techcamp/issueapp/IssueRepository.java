package in.techcamp.issueapp;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IssueRepository {
    @Insert("insert into issues (title, content, period, importance) values (#{title}, #{content}, #{period}, #{importance})")
    void insert(String title, String content, String period, Character importance);

    @Select("select * from issues")
    List<IssueEntity> findAll();

    @Select("select * from issues where id = #{id}")
    IssueEntity findById(long id);

    @Update("UPDATE issues SET title = #{title}, content = #{content}, period = #{period}, importance = #{importance} WHERE id =#{id}")
    void update(long id, String title, String content, String period, Character importance);

    @Delete("delete from issues where id=#{id}")
    void deleteById(Long id);
}