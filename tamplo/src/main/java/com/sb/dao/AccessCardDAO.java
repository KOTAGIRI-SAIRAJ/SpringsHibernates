package com.sb.dao;

import com.sb.model.AccessCard;
import com.sb.model.Employee;

import java.util.List;

public interface AccessCardDAO {

    public void addAccessCard(AccessCard accessCard);

    public List<AccessCard> getAllAccessCards();

    public void deleteAccessCard(Integer accessCardId);

    public AccessCard updateAccessCard(AccessCard accessCard);

    public AccessCard getAccessCard(int accesscardId);
}
