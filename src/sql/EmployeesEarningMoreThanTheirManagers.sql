# Write your MySQL query statement below
# 查找出比领导薪水高的员工名字
select E1.Name as Employee from Employee as E1, Employee as E2 where E2.Id=E1.ManagerId and E1.Salary > E2.Salary
