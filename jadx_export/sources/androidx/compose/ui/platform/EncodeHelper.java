package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;

/* compiled from: AndroidClipboardManager.android.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        byte[] bytes = this.parcel.marshall();
        return Base64.encodeToString(bytes, 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m4188equalsimpl0(spanStyle.m6096getColor0d7_KjU(), Color.INSTANCE.m4223getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m5897encode8_81llA(spanStyle.m6096getColor0d7_KjU());
        }
        if (!TextUnit.m6887equalsimpl0(spanStyle.getFontSize(), TextUnit.INSTANCE.m6901getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m5894encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight it = spanStyle.getFontWeight();
        if (it != null) {
            encode((byte) 3);
            encode(it);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int it2 = fontStyle.m6261unboximpl();
            encode((byte) 4);
            m5899encodenzbMABs(it2);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int it3 = fontSynthesis.getValue();
            encode((byte) 5);
            m5896encode6p3vJLY(it3);
        }
        String it4 = spanStyle.getFontFeatureSettings();
        if (it4 != null) {
            encode((byte) 6);
            encode(it4);
        }
        if (!TextUnit.m6887equalsimpl0(spanStyle.getLetterSpacing(), TextUnit.INSTANCE.m6901getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m5894encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float it5 = baselineShift.m6440unboximpl();
            encode((byte) 8);
            m5895encode4Dl_Bck(it5);
        }
        TextGeometricTransform it6 = spanStyle.getTextGeometricTransform();
        if (it6 != null) {
            encode((byte) 9);
            encode(it6);
        }
        if (!Color.m4188equalsimpl0(spanStyle.getBackground(), Color.INSTANCE.m4223getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m5897encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration it7 = spanStyle.getTextDecoration();
        if (it7 != null) {
            encode((byte) 11);
            encode(it7);
        }
        Shadow it8 = spanStyle.getShadow();
        if (it8 != null) {
            encode((byte) 12);
            encode(it8);
        }
    }

    /* renamed from: encode-8_81llA, reason: not valid java name */
    public final void m5897encode8_81llA(long color) {
        m5898encodeVKZWuLQ(color);
    }

    /* renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m5894encodeR2X_6o(long textUnit) {
        long jM6889getTypeUIouoOA = TextUnit.m6889getTypeUIouoOA(textUnit);
        byte typeCode = 0;
        if (!TextUnitType.m6918equalsimpl0(jM6889getTypeUIouoOA, TextUnitType.INSTANCE.m6924getUnspecifiedUIouoOA())) {
            if (TextUnitType.m6918equalsimpl0(jM6889getTypeUIouoOA, TextUnitType.INSTANCE.m6923getSpUIouoOA())) {
                typeCode = 1;
            } else if (TextUnitType.m6918equalsimpl0(jM6889getTypeUIouoOA, TextUnitType.INSTANCE.m6922getEmUIouoOA())) {
                typeCode = 2;
            }
        }
        encode(typeCode);
        if (!TextUnitType.m6918equalsimpl0(TextUnit.m6889getTypeUIouoOA(textUnit), TextUnitType.INSTANCE.m6924getUnspecifiedUIouoOA())) {
            encode(TextUnit.m6890getValueimpl(textUnit));
        }
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m5899encodenzbMABs(int fontStyle) {
        byte b = 0;
        if (!FontStyle.m6258equalsimpl0(fontStyle, FontStyle.INSTANCE.m6265getNormal_LCdwA()) && FontStyle.m6258equalsimpl0(fontStyle, FontStyle.INSTANCE.m6264getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m5896encode6p3vJLY(int fontSynthesis) {
        byte value = 0;
        if (!FontSynthesis.m6269equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m6276getNoneGVVA2EU())) {
            if (FontSynthesis.m6269equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m6275getAllGVVA2EU())) {
                value = 1;
            } else if (FontSynthesis.m6269equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m6278getWeightGVVA2EU())) {
                value = 2;
            } else if (FontSynthesis.m6269equalsimpl0(fontSynthesis, FontSynthesis.INSTANCE.m6277getStyleGVVA2EU())) {
                value = 3;
            }
        }
        encode(value);
    }

    /* renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m5895encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m5897encode8_81llA(shadow.getColor());
        encode(Offset.m3945getXimpl(shadow.getOffset()));
        encode(Offset.m3946getYimpl(shadow.getOffset()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m5898encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }
}
