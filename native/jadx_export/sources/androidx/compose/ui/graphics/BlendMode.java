package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BlendMode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class BlendMode {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Clear = m4096constructorimpl(0);
    private static final int Src = m4096constructorimpl(1);
    private static final int Dst = m4096constructorimpl(2);
    private static final int SrcOver = m4096constructorimpl(3);
    private static final int DstOver = m4096constructorimpl(4);
    private static final int SrcIn = m4096constructorimpl(5);
    private static final int DstIn = m4096constructorimpl(6);
    private static final int SrcOut = m4096constructorimpl(7);
    private static final int DstOut = m4096constructorimpl(8);
    private static final int SrcAtop = m4096constructorimpl(9);
    private static final int DstAtop = m4096constructorimpl(10);
    private static final int Xor = m4096constructorimpl(11);
    private static final int Plus = m4096constructorimpl(12);
    private static final int Modulate = m4096constructorimpl(13);
    private static final int Screen = m4096constructorimpl(14);
    private static final int Overlay = m4096constructorimpl(15);
    private static final int Darken = m4096constructorimpl(16);
    private static final int Lighten = m4096constructorimpl(17);
    private static final int ColorDodge = m4096constructorimpl(18);
    private static final int ColorBurn = m4096constructorimpl(19);
    private static final int Hardlight = m4096constructorimpl(20);
    private static final int Softlight = m4096constructorimpl(21);
    private static final int Difference = m4096constructorimpl(22);
    private static final int Exclusion = m4096constructorimpl(23);
    private static final int Multiply = m4096constructorimpl(24);
    private static final int Hue = m4096constructorimpl(25);
    private static final int Saturation = m4096constructorimpl(26);
    private static final int Color = m4096constructorimpl(27);
    private static final int Luminosity = m4096constructorimpl(28);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m4095boximpl(int i) {
        return new BlendMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4096constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4097equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4098equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4099hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4097equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4099hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ BlendMode(int value) {
        this.value = value;
    }

    /* compiled from: BlendMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u0019\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u0019\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u0019\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u0019\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u0019\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b3\u0010\u0006R\u0019\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u0019\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u0019\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u0019\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u0019\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u0019\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b?\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Saturation", "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m4102getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m4125getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m4108getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m4129getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m4112getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m4127getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m4110getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m4128getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m4111getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m4126getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m4109getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m4130getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m4121getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m4118getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m4123getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m4120getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m4106getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m4116getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m4105getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m4104getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m4114getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m4124getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m4107getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m4113getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m4119getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m4115getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m4122getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m4103getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m4117getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4100toStringimpl(int arg0) {
        return m4098equalsimpl0(arg0, Clear) ? "Clear" : m4098equalsimpl0(arg0, Src) ? "Src" : m4098equalsimpl0(arg0, Dst) ? "Dst" : m4098equalsimpl0(arg0, SrcOver) ? "SrcOver" : m4098equalsimpl0(arg0, DstOver) ? "DstOver" : m4098equalsimpl0(arg0, SrcIn) ? "SrcIn" : m4098equalsimpl0(arg0, DstIn) ? "DstIn" : m4098equalsimpl0(arg0, SrcOut) ? "SrcOut" : m4098equalsimpl0(arg0, DstOut) ? "DstOut" : m4098equalsimpl0(arg0, SrcAtop) ? "SrcAtop" : m4098equalsimpl0(arg0, DstAtop) ? "DstAtop" : m4098equalsimpl0(arg0, Xor) ? "Xor" : m4098equalsimpl0(arg0, Plus) ? "Plus" : m4098equalsimpl0(arg0, Modulate) ? "Modulate" : m4098equalsimpl0(arg0, Screen) ? "Screen" : m4098equalsimpl0(arg0, Overlay) ? "Overlay" : m4098equalsimpl0(arg0, Darken) ? "Darken" : m4098equalsimpl0(arg0, Lighten) ? "Lighten" : m4098equalsimpl0(arg0, ColorDodge) ? "ColorDodge" : m4098equalsimpl0(arg0, ColorBurn) ? "ColorBurn" : m4098equalsimpl0(arg0, Hardlight) ? "HardLight" : m4098equalsimpl0(arg0, Softlight) ? "Softlight" : m4098equalsimpl0(arg0, Difference) ? "Difference" : m4098equalsimpl0(arg0, Exclusion) ? "Exclusion" : m4098equalsimpl0(arg0, Multiply) ? "Multiply" : m4098equalsimpl0(arg0, Hue) ? "Hue" : m4098equalsimpl0(arg0, Saturation) ? "Saturation" : m4098equalsimpl0(arg0, Color) ? "Color" : m4098equalsimpl0(arg0, Luminosity) ? "Luminosity" : "Unknown";
    }

    public String toString() {
        return m4100toStringimpl(this.value);
    }
}
