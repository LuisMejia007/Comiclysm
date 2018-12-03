export class Inventory {

    inventoryId: number;
    inventoryName: string;
    inventoryUserId: number;

    constructor() { }

    setInventoryId(id: number) {
        this.inventoryId = id;
    }

    setInventoryName(name: string) {
        this.inventoryName = name;
    }

    setInventoryUserId(id: number) {
        this.inventoryUserId = id;
    }

    getInventoryId() {
        return this.inventoryId;
    }

    getInventoryName() {
        return this.inventoryName;
    }

    getInventoryUserId() {
        return this.inventoryUserId;
    }
}
