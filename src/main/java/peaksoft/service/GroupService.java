package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entities.Group;
import peaksoft.entities.Student;

import java.util.List;
@Service

public interface GroupService{
    List<Group> getAllGroups();
    void addGroup(Long groupId,Group group);
    Group getGroupById(Long groupId);
    void updateGroup(Long groupId,Long courseId,Group group);
    void deleteGroup(Group group);
}
