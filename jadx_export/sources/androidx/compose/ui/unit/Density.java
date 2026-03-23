package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* renamed from: roundToPx--R2X_6o */
    int mo360roundToPxR2X_6o(long j);

    /* renamed from: roundToPx-0680j_4 */
    int mo361roundToPx0680j_4(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo363toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo364toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM */
    long mo365toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o */
    float mo366toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4 */
    float mo367toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* renamed from: toSize-XkaWNTQ */
    long mo368toSizeXkaWNTQ(long j);

    /* renamed from: toSp-kPz2Gy4 */
    long mo370toSpkPz2Gy4(float f);

    /* renamed from: toSp-kPz2Gy4 */
    long mo371toSpkPz2Gy4(int i);

    /* compiled from: Density.kt */
    /* renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m6663$default$toPx0680j_4(Density _this, float $this$toPx_u2d0680j_4) {
            return _this.getDensity() * $this$toPx_u2d0680j_4;
        }

        /* renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m6658$default$roundToPx0680j_4(Density _this, float $this$roundToPx_u2d0680j_4) {
            float px = _this.mo367toPx0680j_4($this$roundToPx_u2d0680j_4);
            if (Float.isInfinite(px)) {
                return Integer.MAX_VALUE;
            }
            return Math.round(px);
        }

        /* renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m6662$default$toPxR2X_6o(Density _this, long $this$toPx_u2d_u2dR2X_6o) {
            if (TextUnitType.m6918equalsimpl0(TextUnit.m6889getTypeUIouoOA($this$toPx_u2d_u2dR2X_6o), TextUnitType.INSTANCE.m6923getSpUIouoOA())) {
                return _this.mo367toPx0680j_4(_this.mo362toDpGaN1DYA($this$toPx_u2d_u2dR2X_6o));
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m6657$default$roundToPxR2X_6o(Density _this, long $this$roundToPx_u2d_u2dR2X_6o) {
            float $this$fastRoundToInt$iv = _this.mo366toPxR2X_6o($this$roundToPx_u2d_u2dR2X_6o);
            return Math.round($this$fastRoundToInt$iv);
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m6660$default$toDpu2uoSUM(Density _this, int $this$toDp_u2du2uoSUM) {
            float $this$dp$iv = $this$toDp_u2du2uoSUM / _this.getDensity();
            return Dp.m6693constructorimpl($this$dp$iv);
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m6666$default$toSpkPz2Gy4(Density _this, int $this$toSp_u2dkPz2Gy4) {
            return _this.mo369toSp0xMU5do(_this.mo364toDpu2uoSUM($this$toSp_u2dkPz2Gy4));
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m6659$default$toDpu2uoSUM(Density _this, float $this$toDp_u2du2uoSUM) {
            float $this$dp$iv = $this$toDp_u2du2uoSUM / _this.getDensity();
            return Dp.m6693constructorimpl($this$dp$iv);
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m6665$default$toSpkPz2Gy4(Density _this, float $this$toSp_u2dkPz2Gy4) {
            return _this.mo369toSp0xMU5do(_this.mo363toDpu2uoSUM($this$toSp_u2dkPz2Gy4));
        }

        public static Rect $default$toRect(Density _this, DpRect $this$toRect) {
            return new Rect(_this.mo367toPx0680j_4($this$toRect.m6776getLeftD9Ej5fM()), _this.mo367toPx0680j_4($this$toRect.m6778getTopD9Ej5fM()), _this.mo367toPx0680j_4($this$toRect.m6777getRightD9Ej5fM()), _this.mo367toPx0680j_4($this$toRect.m6775getBottomD9Ej5fM()));
        }

        /* renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m6664$default$toSizeXkaWNTQ(Density _this, long $this$toSize_u2dXkaWNTQ) {
            if ($this$toSize_u2dXkaWNTQ != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                return SizeKt.Size(_this.mo367toPx0680j_4(DpSize.m6791getWidthD9Ej5fM($this$toSize_u2dXkaWNTQ)), _this.mo367toPx0680j_4(DpSize.m6789getHeightD9Ej5fM($this$toSize_u2dXkaWNTQ)));
            }
            return Size.INSTANCE.m4022getUnspecifiedNHjbRc();
        }

        /* renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6661$default$toDpSizekrfVVM(Density _this, long $this$toDpSize_u2dk_u2drfVVM) {
            if ($this$toDpSize_u2dk_u2drfVVM != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                return DpKt.m6715DpSizeYgX7TsA(_this.mo363toDpu2uoSUM(Size.m4014getWidthimpl($this$toDpSize_u2dk_u2drfVVM)), _this.mo363toDpu2uoSUM(Size.m4011getHeightimpl($this$toDpSize_u2dk_u2drfVVM)));
            }
            return DpSize.INSTANCE.m6800getUnspecifiedMYxV2XQ();
        }
    }

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6681toDpGaN1DYA(Density $this, long $receiver) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6688toSp0xMU5do(Density $this, float $receiver) {
            return FontScaling.CC.m6803$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6686toPx0680j_4(Density $this, float $receiver) {
            return CC.m6663$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6680roundToPx0680j_4(Density $this, float $receiver) {
            return CC.m6658$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6685toPxR2X_6o(Density $this, long $receiver) {
            return CC.m6662$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6679roundToPxR2X_6o(Density $this, long $receiver) {
            return CC.m6657$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6683toDpu2uoSUM(Density $this, int $receiver) {
            return CC.m6660$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6690toSpkPz2Gy4(Density $this, int $receiver) {
            return CC.m6666$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6682toDpu2uoSUM(Density $this, float $receiver) {
            return CC.m6659$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6689toSpkPz2Gy4(Density $this, float $receiver) {
            return CC.m6665$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(Density $this, DpRect $receiver) {
            return CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6687toSizeXkaWNTQ(Density $this, long $receiver) {
            return CC.m6664$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6684toDpSizekrfVVM(Density $this, long $receiver) {
            return CC.m6661$default$toDpSizekrfVVM($this, $receiver);
        }
    }
}
