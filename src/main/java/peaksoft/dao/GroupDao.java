package peaksoft.dao;

import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Student;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroups();

    void addGroup(Long groupId, Group group);

    Group getGroupById(Long groupId);
    void updateGroup(Long groupId,Long courseId,Group group);
    void deleteGroup(Group group);

}
