export class User {
    userId: number;
    userName: string;
    userPassword: string;

    constructor() { }

    getUserName(): string {
        return this.userName;
    }
    getUserPassword(): string {
        return this.userPassword;
    }
    getUserId(): number {
        return this.userId;
    }
    setUserName(userName: string) {
        this.userName = userName;
    }

    setUserPassword(userPassword: string) {
        this.userPassword = userPassword;
    }

    setUserId(id: number) {
        this.userId = id;
    }
}
