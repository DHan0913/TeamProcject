package himedia.dvd.services;

public interface PermissionService {
    boolean hasPermission(Long userNo, Long productNo);
    void setPermission(Long userNo, Long productNo);
}
