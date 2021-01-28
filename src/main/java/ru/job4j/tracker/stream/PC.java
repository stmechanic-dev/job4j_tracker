package ru.job4j.tracker.stream;

public class PC {
    private String modelCPU;
    private String motherBoard;
    private byte sizeRAM;
    private boolean discVideoCard;
    private short powerSupply;
    private String pcCase;
    private int sizeSSD;

    static class Builder {
        private String modelCPU;
        private String motherBoard;
        private byte sizeRAM;
        private boolean discVideoCard;
        private short powerSupply;
        private String pcCase;
        private int sizeSSD;

        Builder buildModelCPU(String modelCPU) {
            this.modelCPU = modelCPU;
            return this;
        }

        Builder buildMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        Builder buildSizeRAM(byte sizeRam) {
            this.sizeRAM = sizeRam;
            return this;
        }

        Builder buildDiscVideoCard(boolean discVideoCard) {
            this.discVideoCard = discVideoCard;
            return this;
        }

        Builder buildPowerSupply(short powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        Builder buildPcCase(String pcCase) {
            this.pcCase = pcCase;
            return this;
        }

        Builder buildSizeSSD(int sizeSSD) {
            this.sizeSSD = sizeSSD;
            return this;
        }
    }
}
