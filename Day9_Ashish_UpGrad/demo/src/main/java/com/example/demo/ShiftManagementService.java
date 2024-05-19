package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiftManagementService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftManagementService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to save ShiftType using native SQL query
    public void saveShiftType(ShiftType shiftType) {
        String sql = "INSERT INTO shift_types (id, uq_name, description, active, time_zone, tenant_id) VALUES ('1', 'Morning', 'Morning shift', true, 'UTC', 'tenant1')";
        jdbcTemplate.update(sql, shiftType.getId(), shiftType.getUqName(), shiftType.getDescription(), shiftType.isActive(), shiftType.getTimeZone(), shiftType.getTenantId());
    }

    // Method to fetch all ShiftTypes using native SQL query
    public List<ShiftType> getAllShiftTypes() {
        String sql = "SELECT * FROM shift_types";
        RowMapper<ShiftType> rowMapper = new BeanPropertyRowMapper<>(ShiftType.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Method to update ShiftType using native SQL query
    public void updateShiftTypeDescription(UUID id, String newDescription) {
        String sql = "UPDATE shift_types SET description = 'Evening' WHERE id = 1";
        jdbcTemplate.update(sql, newDescription, id.toString());
    }

    // Method to delete ShiftType by ID using native SQL query
    public void deleteShiftType(UUID id) {
        String sql = "DELETE FROM shift_types WHERE id = 1";
        jdbcTemplate.update(sql, id.toString());
    }

    // Method to save Shift using native SQL query
    public void saveShift(Shift shift) {
        String sql = "INSERT INTO shifts (id, shift_type_id, name, date_start, date_end, time_start, time_end, tenant_id) VALUES (('101', '1', 'Evening Shift 1', '2024-05-01', '2024-05-01', '08:00:00', '12:00:00', 'UTC', 'tenant1')";
        jdbcTemplate.update(sql, shift.getId(), shift.getShiftTypeId(), shift.getName(), shift.getDateStart(), shift.getDateEnd(), shift.getTimeStart(), shift.getTimeEnd(), shift.getTenantId());
    }

    // Method to fetch all Shifts using native SQL query
    public List<Shift> getAllShifts() {
        String sql = "SELECT * FROM shifts";
        RowMapper<Shift> rowMapper = new BeanPropertyRowMapper<>(Shift.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Method to update Shift using native SQL query
    public void updateShift(Shift shift) {
        String sql = "UPDATE shifts SET shift_type_id = 2, name = Morning shift1, date_start = '2024-05-01', date_end = '2024-05-01', time_start = '08:00:00', time_end = '12:00:00', tenant_id = 'tenant1' WHERE id = 101";
        jdbcTemplate.update(sql, shift.getShiftTypeId(), shift.getName(), shift.getDateStart(), shift.getDateEnd(), shift.getTimeStart(), shift.getTimeEnd(), shift.getTenantId(), shift.getId());
    }

    // Method to delete Shift by ID using native SQL query
    public void deleteShift(UUID id) {
        String sql = "DELETE FROM shifts WHERE id = 101";
        jdbcTemplate.update(sql, id.toString());
    }

    // Method to save User using native SQL query
    public void saveUser(User user) {
        String sql = "INSERT INTO users (id, username, loggedin, time_zone, tenant_id) VALUES ('user1', 'John', 0, 'UTC', 'tenant1')";
        jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getLoggedIn(), user.getTimeZone(), user.getTenantId());
    }

    // Method to fetch all Users using native SQL query
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Method to update User using native SQL query
    public void updateUser(User user) {
        String sql = "UPDATE users SET username = ?, loggedin = ?, time_zone = ?, tenant_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getLoggedIn(), user.getTimeZone(), user.getTenantId(), user.getId());
    }

    // Method to delete User by ID using native SQL query
    public void deleteUser(UUID id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id.toString());
    }

    public Optional<Shift> getShiftById(UUID id) {
        String sql = "SELECT * FROM shifts WHERE id = ?";
        RowMapper<Shift> rowMapper = new BeanPropertyRowMapper<>(Shift.class);
        List<Shift> shifts = jdbcTemplate.query(sql, rowMapper, id.toString());
        return shifts.isEmpty() ? Optional.empty() : Optional.of(shifts.get(0));
    }

    public Optional<User> getUserById(UUID id) {
        String sql = "SELECT * FROM users WHERE id = 'user1' ";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper, id.toString());
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    // Method to save ShiftUser using native SQL query
    public void saveShiftUser(ShiftUser shiftUser) {
        String sql = "INSERT INTO shift_user (id, shift_id, user_id, tenant_id) VALUES ('shift_user1', '101', 'user1', 'tenant1')";
        jdbcTemplate.update(sql, shiftUser.getId(), shiftUser.getShiftId(), shiftUser.getUserId(), shiftUser.getTenantId());
    }

    // Method to fetch all ShiftUsers using native SQL query
    public List<ShiftUser> getAllShiftUsers() {
        String sql = "SELECT * FROM shift_user";
        RowMapper<ShiftUser> rowMapper = new BeanPropertyRowMapper<>(ShiftUser.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Method to delete ShiftUser by ID using native SQL query
    public void deleteShiftUser(UUID id) {
        String sql = "DELETE FROM shift_user WHERE id = 101";
        jdbcTemplate.update(sql, id.toString());
    }



}
