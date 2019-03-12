import java.util.HashMap;

public class Main {
    public static abstract class Color {
        abstract RgbColor toRgb();
        abstract HsvColor toHsv();
        abstract Gs8Color toGs8();
        int toRgbInt() {
            RgbColor rgb = this.toRgb();
            int rgbInt = rgb.blue;
            rgbInt = (rgbInt << 8) + rgb.green;
            rgbInt = (rgbInt << 8) + rgb.red;
            return rgbInt;
        }
        double distanceTo(Color other) {
            RgbColor rgbThis = this.toRgb();
            RgbColor rgbOther = other.toRgb();
            int redD = Math.abs(rgbOther.red - rgbThis.red);
            int greenD = Math.abs(rgbOther.green - rgbThis.green);
            int blueD = Math.abs(rgbOther.blue - rgbThis.blue);
            return Math.sqrt(redD * redD + greenD * greenD + blueD * blueD);
        }
    }
    public static class RgbColor extends Color {
        protected int red;
        protected int green;
        protected int blue;
        public RgbColor() {
            this(0, 0, 0);
        }
        public RgbColor(int rgb) {
            this.red = (rgb >> 16) & 0xFF;
            this.green = (rgb >> 8) & 0xFF;
            this.blue = rgb & 0xFF;
        }
        public RgbColor(RgbColor other) {
            this(other.red, other.green, other.blue);
        }
        public RgbColor(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
        public RgbColor toRgb() {
            return this;
        }
        public HsvColor toHsv() {
            double redN = (double) this.red / 255;
            double greenN = (double) this.green / 255;
            double blueN = (double) this.blue / 255;
            double cMax = Math.max(redN, Math.max(greenN, blueN));
            double cMin = Math.min(redN, Math.min(greenN, blueN));
            double delta = cMax - cMin;
            double hue = -1;
            if (delta == 0)
                hue = 0;
            else if (cMax == redN)
                hue = 60 * (((greenN - blueN) / delta) % 6);
            else if (cMax == greenN)
                hue = 60 * (((blueN - redN) / delta) + 2);
            else if (cMax == blueN)
                hue = 60 * (((redN - greenN) / delta) + 4);
            double saturation = cMax == 0 ? 0 : delta / cMax;
            double value = cMax;
            return new HsvColor((int) hue, (int) saturation, (int) value);

        }
        public Gs8Color toGs8() {
            return new Gs8Color((short) (0.2989 * this.red + 0.5870 * this.green + 0.1140 * this.blue));
        }
    }
    public static class HsvColor extends Color {
        protected int hue;
        protected int saturation;
        protected int value;
        public HsvColor() {
            this(0, 0, 0);
        }
        public HsvColor(int rgb) {
            this(new RgbColor(rgb).toHsv());
        }
        public HsvColor(HsvColor other) {
            this(other.hue, other.saturation, other.value);
        }
        public HsvColor(int hue, int saturation, int value) {
            this.hue = hue;
            this.saturation = saturation;
            this.value = value;
        }
        public RgbColor toRgb() {
            double c = this.value * this.saturation;
            double x = c * (1 - Math.abs(((double) this.hue / 60) % 2 - 1));
            double m = this.value - c;
            double redN = -1;
            double greenN = -1;
            double blueN = -1;
            if (0 <= (double) this.hue && (double) this.hue < 60) {
                redN = c;
                greenN = x;
                blueN = 0;
            }
            else if (60 <= (double) this.hue && (double) this.hue < 120) {
                redN = x;
                greenN = c;
                blueN = 0;
            }
            else if (120 <= (double) this.hue && (double) this.hue < 180) {
                redN = 0;
                greenN = c;
                blueN = x;
            }
            else if (180 <= (double) this.hue && (double) this.hue < 240) {
                redN = 0;
                greenN = x;
                blueN = c;
            }
            else if (240 <= (double) this.hue && (double) this.hue < 300) {
                redN = x;
                greenN = 0;
                blueN = c;
            }
            else if (300 <= (double) this.hue && (double) this.hue < 360) {
                redN = c;
                greenN = 0;
                blueN = x;
            }
            return new RgbColor((int) (redN + m) * 255, (int) (greenN + m) * 255, (int) (blueN + m) * 255);
        }
        public HsvColor toHsv() {
            return this;
        }
        public Gs8Color toGs8() {
            return new Gs8Color((short) value);
        }
    }
    public static class Gs8Color extends Color {
        protected short value;
        public Gs8Color() {
            this((short) 0);
        }
        public Gs8Color(int rgb) {
            this(new RgbColor(rgb).toGs8());
        }
        public Gs8Color(Gs8Color other) {
            this(other.value);
        }
        public Gs8Color(short value) {
            this.value = value;
        }
        public RgbColor toRgb() {
            return new RgbColor(this.value, this.value, this.value);
        }
        public HsvColor toHsv() {
            return new HsvColor(0, 0, this.value);
        }
        public Gs8Color toGs8() {
            return this;
        }
    }
    class ColorPalette {
        protected Color[] colors;
        protected HashMap<Color, Color> friends;
        ColorPalette() {
            this(new Color[0]);
        }
        ColorPalette(int n) {
            this(new Color[n]);
        }
        ColorPalette(Color[] colors) {
            this.colors = colors;
            this.friends = new HashMap<>();
            for (Color color1: colors) {
                double minDistance = -1;
                Color minColor = null;
                for (Color color2 : colors) {
                    if (color1 == color2)
                        continue;
                    double distance = color1.distanceTo(color2);
                    if (minDistance == -1 || distance < minDistance) {
                        minDistance = distance;
                        minColor = color2;
                    }
                }
                this.friends.put(color1, minColor);
            }
        }
        public Color closestTo(Color color) {
            return this.friends.get(color);
        }
    }
    public static void main(String[] args) {

    }
}

