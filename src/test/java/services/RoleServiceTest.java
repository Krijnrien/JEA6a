package services;

import dao.IRoleDao;
import domain.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

    private Role role;
    private RoleService roleService;

    @Mock
    private IRoleDao roleDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roleService = new RoleService(roleDao);
    }

    @Test
    public void getRole_found() {

    }

    @Test
    public void getAllRoles_listFound() {

    }

    @Test
    public void getAllAccountsWithRole_AccountList() {

    }
}
