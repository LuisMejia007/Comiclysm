export class User {
    userName: string;
    userPassword: string;

    constructor() { }

    getUserName(): string {
        return this.userName;
    }
    getUserPassword(): string {
        return this.userPassword;
    }

    setUserName(userName: string) {
        this.userName = userName;
    }

    setUserPassword(userPassword: string) {
        this.userPassword = userPassword;
    }
}
