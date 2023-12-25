/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalibrarymanagement.data.dao;

import java.util.ArrayList;
import javalibrarymanagement.data.model.BookIssue;
import javalibrarymanagement.data.model.Member;

/**
 *
 * @author erenm
 */
public interface BookIssueDao {
    
    public ArrayList<BookIssue> getMyIssues(Member member);
    
}
