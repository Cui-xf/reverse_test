package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.core.view.ViewCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: MeasureScope.kt */
@MeasureScopeMarker
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {
    MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock);

    MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super RulerScope, Unit> rulers, Function1<? super Placeable.PlacementScope, Unit> placementBlock);

    /* compiled from: MeasureScope.kt */
    /* renamed from: androidx.compose.ui.layout.MeasureScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
            }
            if ((i3 & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            return measureScope.layout(i, i2, map, function1);
        }

        public static MeasureResult $default$layout(MeasureScope _this, int width, int height, Map alignmentLines, Function1 placementBlock) {
            return _this.layout(width, height, alignmentLines, null, placementBlock);
        }

        public static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, Function1 function12, int i3, Object obj) {
            Map mapEmptyMap;
            Function1 function13;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
            }
            if ((i3 & 4) == 0) {
                mapEmptyMap = map;
            } else {
                mapEmptyMap = MapsKt.emptyMap();
            }
            if ((i3 & 8) == 0) {
                function13 = function1;
            } else {
                function13 = null;
            }
            return measureScope.layout(i, i2, mapEmptyMap, function13, function12);
        }

        public static MeasureResult $default$layout(MeasureScope _this, int width, int height, Map alignmentLines, Function1 rulers, Function1 placementBlock) {
            boolean value$iv$iv = (width & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & height) == 0;
            if (!value$iv$iv) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            return new MeasureResult(width, height, alignmentLines, rulers, _this, placementBlock) { // from class: androidx.compose.ui.layout.MeasureScope.layout.1
                final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
                final /* synthetic */ int $width;
                private final Map<AlignmentLine, Integer> alignmentLines;
                private final int height;
                private final Function1<RulerScope, Unit> rulers;
                final /* synthetic */ MeasureScope this$0;
                private final int width;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$width = width;
                    this.this$0 = _this;
                    this.$placementBlock = placementBlock;
                    this.width = width;
                    this.height = height;
                    this.alignmentLines = alignmentLines;
                    this.rulers = rulers;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getWidth() {
                    return this.width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getHeight() {
                    return this.height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return this.alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Function1<RulerScope, Unit> getRulers() {
                    return this.rulers;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    boolean z = this.this$0 instanceof LookaheadCapablePlaceable;
                    Function1<Placeable.PlacementScope, Unit> function1 = this.$placementBlock;
                    if (z) {
                        function1.invoke(((LookaheadCapablePlaceable) this.this$0).getPlacementScope());
                    } else {
                        function1.invoke(new SimplePlacementScope(this.$width, this.this$0.getLayoutDirection()));
                    }
                }
            };
        }
    }

    /* compiled from: MeasureScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isLookingAhead(MeasureScope $this) {
            return IntrinsicMeasureScope.CC.$default$isLookingAhead($this);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5583roundToPxR2X_6o(MeasureScope $this, long $receiver) {
            return Density.CC.m6657$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5584roundToPx0680j_4(MeasureScope $this, float $receiver) {
            return Density.CC.m6658$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5585toDpGaN1DYA(MeasureScope $this, long $receiver) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5586toDpu2uoSUM(MeasureScope $this, float $receiver) {
            return Density.CC.m6659$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5587toDpu2uoSUM(MeasureScope $this, int $receiver) {
            return Density.CC.m6660$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5588toDpSizekrfVVM(MeasureScope $this, long $receiver) {
            return Density.CC.m6661$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5589toPxR2X_6o(MeasureScope $this, long $receiver) {
            return Density.CC.m6662$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5590toPx0680j_4(MeasureScope $this, float $receiver) {
            return Density.CC.m6663$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(MeasureScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5591toSizeXkaWNTQ(MeasureScope $this, long $receiver) {
            return Density.CC.m6664$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5592toSp0xMU5do(MeasureScope $this, float $receiver) {
            return FontScaling.CC.m6803$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5593toSpkPz2Gy4(MeasureScope $this, float $receiver) {
            return Density.CC.m6665$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5594toSpkPz2Gy4(MeasureScope $this, int $receiver) {
            return Density.CC.m6666$default$toSpkPz2Gy4((Density) $this, $receiver);
        }

        @Deprecated
        public static MeasureResult layout(MeasureScope $this, int width, int height, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            return CC.$default$layout($this, width, height, map, function1);
        }

        @Deprecated
        public static MeasureResult layout(MeasureScope $this, int width, int height, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12) {
            return CC.$default$layout($this, width, height, map, function1, function12);
        }
    }
}
